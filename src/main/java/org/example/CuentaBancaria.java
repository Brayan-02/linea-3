package org.example;

public class CuentaBancaria {
    private String titular,numeroCuenta;
    private double saldo;

    public CuentaBancaria() {
    }

    public CuentaBancaria(String numeroCuenta, String titular, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "titular='" + titular + '\'' +
                ", numeroCuenta='" + numeroCuenta + '\'' +
                ", saldo=" + saldo +
                '}';
    }

    public double ingresarSaldo(double saldoingresado){
        saldo= this.saldo + saldoingresado;
        return saldo;
    }

    public boolean retirarSaldo(double saldoaRetirar) {
        if (saldoaRetirar <= saldo) {
            saldo -= saldoaRetirar;
            return true;
        } else {
            return false;
        }
    }
}
