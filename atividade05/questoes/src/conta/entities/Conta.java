package conta.entities;

public class Conta {
     public String numero;
     public float saldo;

     public Conta(String numero, float saldo){
         this.numero = numero;
         this.saldo = saldo;
     }

     public boolean sacar(float saque){
         float valorAtualConta = saldo - saque;

         if(valorAtualConta < 0){
//             System.out.println("O saque não poderá ser efetuado..");
             return false;
         }else{
//             System.out.println("Saque efetuado...");
             saldo = valorAtualConta;
             return true;
         }
     }

     public void depositar(float deposito){
         saldo += deposito;
     }

    public boolean transferir(Conta contaDestino, float valorTransferencia) {
        // Verifica se a conta de origem tem saldo suficiente para a transferência
        if (this.sacar(valorTransferencia)) {
            // Se o saque for bem-sucedido, realiza o depósito na conta de destino
            contaDestino.depositar(valorTransferencia);
            return true;  // Transferência realizada com sucesso
        }
        return false;  // Não foi possível realizar a transferência (saldo insuficiente)
    }

    public float exibirSaldo(){
         return saldo;
     }
}