# Springbank

API REST de un banco construida con Spring Boot, JPA e H2.

## Modelo de entidades

### Client
Representa un cliente del banco. Tiene nombre, apellido, email, teléfono y contraseña.

### Account
Una cuenta bancaria pertenece a un cliente. Puede ser de tipo **CHECKING** (cuenta corriente) o **SAVINGS** (caja de ahorro), definido con el enum `AccountType`. El balance se representa con `BigDecimal` en lugar de `double` para evitar problemas de precisión en operaciones financieras. Además del `id` técnico, tiene un `accountNumber` como identificador de negocio visible al usuario.

Un cliente puede tener múltiples cuentas.

### Card
Una tarjeta pertenece a un cliente y puede ser de tipo **DEBIT** o **CREDIT** (enum `CardType`). La tarjeta de débito está además asociada a una cuenta específica; la de crédito no (la relación con `Account` es nullable). El campo `limit` es nullable porque solo aplica a tarjetas de crédito.

### CardSummary
Resumen mensual de una tarjeta de crédito. Contiene fecha de cierre, fecha de vencimiento, monto total y monto mínimo a pagar. Pertenece a una tarjeta (`@ManyToOne`). Una tarjeta tiene muchos resúmenes, uno por mes.

### Transaction (herencia JOINED)
Clase base para movimientos. Tiene monto, fecha, descripción y tipo (enum `TransactionType`). Usa estrategia de herencia `JOINED` — cada subclase tiene su propia tabla que comparte el `id` con la tabla base.

- **DebitTransaction** — agrega la relación con `Account` (nullable = false). Representa pagos con débito o transferencias.
- **CreditTransaction** — agrega `installments` (total de cuotas), `currentInstallment` (cuota actual) y relación con `CardSummary`. Las cuotas de tarjeta no tienen fecha de vencimiento propia, se incluyen en el resumen mensual.

La razón para separar en subclases es que una compra con tarjeta de crédito no descuenta saldo de ninguna cuenta en el momento — solo genera deuda en el resumen. Por eso `account` no puede ser `nullable = false` en la clase base.

### Loan
Un préstamo pertenece a un cliente. Tiene monto, tasa de interés, cantidad de cuotas y fecha de inicio. La fecha de fin no se guarda porque es calculable a partir de `startDate` + `installmentCount`.

### Installment
Cada cuota de un préstamo es una entidad separada con fecha de vencimiento, monto y estado (`PAID` / `PENDING`, enum `StatusInstallment`). Pertenece a un `Loan` (`@ManyToOne`). Las cuotas de préstamo tienen fecha de vencimiento propia, a diferencia de las cuotas de compra con tarjeta.

## Relaciones

```
Client ──< Account
Client ──< Card
Client ──< Loan ──< Installment
Card ──< CardSummary
Card >──(nullable) Account
Account ──< DebitTransaction
CardSummary ──< CreditTransaction
```

## Decisiones de diseño

- **`BigDecimal` para dinero y tasas** — `double` tiene problemas de precisión con punto flotante que son inaceptables en un sistema financiero
- **`LocalDate` para fechas** — clase moderna de Java, reemplaza el obsoleto `java.util.Date`
- **Enums con `@Enumerated(EnumType.STRING)`** — se guarda el texto (`"PAID"`, `"CREDIT"`) en vez del índice numérico, lo que hace la base de datos legible
- **`id` técnico + `accountNumber`** — la PK nunca cambia; el número de cuenta es el identificador de negocio y puede modificarse sin afectar las relaciones internas
- **Herencia JOINED en Transaction** — permite tener `account` como obligatorio en débito y ausente en crédito, sin nulls innecesarios en la tabla base
- **`endDate` calculable en Loan** — no se persiste datos que se pueden derivar de otros campos

## Stack

- Java 21
- Spring Boot
- Spring Data JPA
- H2 (base de datos en memoria)
- Lombok
