package entities;

import entities.exceptions.ObjetoNullException;
import entities.exceptions.SaldoInsuficienteException;
import entities.exceptions.ValorinconpativelException;

public class Conta {
    private int id;
    private String numero_conta;
    private float saldo;

    public Conta() {
        this.id = 0;
        this.numero_conta = "";
        this.saldo = 0;
    }

    public String getNumero_conta() {
        return numero_conta;
    }

    public void setNumero_conta(String numero_conta) {
        this.numero_conta = numero_conta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void depositar(float valor) {
        this.saldo += valor;
    }

    public void sacar(float valor) {
        this.saldo -= valor;
    }

    public boolean validaValor(float valor) {
        try {
            if(valor >= 0) {
                throw new ValorinconpativelException();
            }
            return true;
        }catch (ValorinconpativelException e) {
            return false;
        }

    }

    public void transferir(float valor, Conta conta, Conta receptora) {
       try{
            if(conta == null || receptora == null) {
                throw new ObjetoNullException("Alguma das contas devem ser null");
            }

            if(conta.getSaldo() < valor) {
                throw new SaldoInsuficienteException("Saldo insuficiente");
            }

            conta.sacar(valor);
            receptora.depositar(valor);

           System.out.println("Transferencia com sucesso");
       }catch (Exception erro) {
           erro.printStackTrace();
       }
    }
}
