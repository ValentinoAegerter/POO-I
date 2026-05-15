public class SaldoInsuficienteException extends Exception {
    private final double saldoActual;
    private final double montoSolicitado;

    public SaldoInsuficienteException(double saldoActual, double montoSolicitado) {
        super("Saldo insuficiente: saldoActual=" + saldoActual + ", montoSolicitado=" + montoSolicitado);
        this.saldoActual = saldoActual;
        this.montoSolicitado = montoSolicitado;
    }

    public double getSaldoActual() {
        return saldoActual;
    }

    public double getMontoSolicitado() {
        return montoSolicitado;
    }
}
