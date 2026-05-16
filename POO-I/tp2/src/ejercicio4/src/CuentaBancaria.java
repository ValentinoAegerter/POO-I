public class CuentaBancaria {
    private final String titular;
    private double saldo;
    private int contadorOperaciones;

    public CuentaBancaria(String titular, double saldoInicial) throws MontoInvalidoException {
        if (saldoInicial < 0) {
            throw new MontoInvalidoException("Saldo inicial inválido: " + saldoInicial);
        }
        this.titular = titular;
        this.saldo = saldoInicial;
        this.contadorOperaciones = 0;
    }

    public void depositar(double monto) throws MontoInvalidoException {
        if (monto <= 0) {
            throw new MontoInvalidoException("Monto a depositar inválido: " + monto);
        }
        this.saldo += monto;
        this.contadorOperaciones++;
    }

    public void retirar(double monto) throws MontoInvalidoException, SaldoInsuficienteException {
        if (monto <= 0) {
            throw new MontoInvalidoException("Monto a retirar inválido: " + monto);
        }
        if (monto > this.saldo) {
            throw new SaldoInsuficienteException(this.saldo, monto);
        }
        this.saldo -= monto;
        this.contadorOperaciones++;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getContadorOperaciones() {
        return contadorOperaciones;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{titular='" + titular + "', saldo=" + saldo + ", operaciones=" + contadorOperaciones + "}";
    }

    // main de demostración
    public static void main(String[] args) {
        CuentaBancaria cuenta = null;
        try {
            // Crear cuenta válida
            cuenta = new CuentaBancaria("Ana", 100.0);
            System.out.println("Cuenta creada: " + cuenta);

            // Depositar 50
            cuenta.depositar(50.0);
            System.out.println("Después de depositar 50: saldo=" + cuenta.getSaldo());

            // Retirar 30 (este retiro ahora está cubierto por los catch del try principal)
            cuenta.retirar(30.0);
            System.out.println("Después de retirar 30: saldo=" + cuenta.getSaldo());

            // Intentar retirar más del saldo disponible
            try {
                cuenta.retirar(1000.0);
            } catch (SaldoInsuficienteException sie) {
                System.out.println("Capturada SaldoInsuficienteException: " + sie.getMessage());
                System.out.println("Saldo actual=" + sie.getSaldoActual() + ", monto solicitado=" + sie.getMontoSolicitado());
            }

            // Intentar depositar monto negativo
            try {
                cuenta.depositar(-20.0);
            } catch (MontoInvalidoException mie) {
                System.out.println("Capturada MontoInvalidoException al depositar: " + mie.getMessage());
            }

        } catch (MontoInvalidoException mie) {
            System.out.println("No se pudo crear la cuenta o hubo un monto inválido: " + mie.getMessage());
        } catch (SaldoInsuficienteException sie) {
            // Captura adicional por si alguna retirada en el bloque try principal falla
            System.out.println("Capturada SaldoInsuficienteException en bloque principal: " + sie.getMessage());
            System.out.println("Saldo actual=" + sie.getSaldoActual() + ", monto solicitado=" + sie.getMontoSolicitado());
        } finally {
            // Bloque finally: siempre mostrar estado final si la cuenta fue creada
            if (cuenta != null) {
                System.out.println("Estado final de la cuenta: " + cuenta);
                System.out.println("Total de operaciones exitosas: " + cuenta.getContadorOperaciones());
            } else {
                System.out.println("La cuenta no fue creada.");
            }
        }

        // Probar crear cuenta con saldo inicial negativo
        try {
            CuentaBancaria cuentaNegativa = new CuentaBancaria("Luis", -10.0);
        } catch (MontoInvalidoException mie) {
            System.out.println("Capturada MontoInvalidoException al crear cuenta: " + mie.getMessage());
        }
    }
}
