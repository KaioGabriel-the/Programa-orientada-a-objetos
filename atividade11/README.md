# ATIVIDADE DE EXCEÇÕES

> ## QUESTÃO 01
> *  ValueError: É quando a função espera um parâmetro de um tipo, mas um de outro tipo é enviado no lugar.
> ```bash
>  def converter_para_inteiro(valor):
>        try:
>           numero = int(valor)
>            print(f"O número convertido é: {numero}")
>        except ValueError:
>           print(f"Erro: O valor '{valor}' não pode ser convertido para inteiro.")
>
>    # Exemplos
>    converter_para_inteiro("123")  # Funciona
>    converter_para_inteiro("texto")  # Gera um ValueError

> * FileNotFoundError: Ocorre quando o programa tenta acessar um arquivo que não existe.
> ```bash
>  def ler_arquivo(nome_arquivo):
>      try:
>         with open(nome_arquivo, "r") as arquivo:
>              conteudo = arquivo.read()
>              print("Conteúdo do arquivo:")
>              print(conteudo)
>      except FileNotFoundError:
>          print(f"Erro: O arquivo '{nome_arquivo}' não foi encontrado.")
>  
>  # Exemplos
>  ler_arquivo("existe.txt")  # Arquivo existe
>  ler_arquivo("nao_existe.txt")  # Gera um FileNotFoundError

> * AttributeError: É quando um objeto tenta acessar um método ou um atributo que não possui.
>```bash
> def acessar_metodo(obj):
>    try:
>        obj.append("item")
>        print("Método 'append' executado com sucesso.")
>    except AttributeError:
>        print(f"Erro: O objeto do tipo '{type(obj).__name__}' não possui o método 'append'.")
>
># Exemplos
>acessar_metodo([])  # Funciona porque listas têm o método append
>acessar_metodo("texto")  # Gera um AttributeError porque strings não possuem append

> ## QUESTÃO 02
> * Porque, todos os códigos acima apenas avisam qual foi o erro e não o resolvem.

> ## QUESTÃO 03
> * Não foi possível realizar a transferência, por causa da condicional que coloquei para verificar se havia saldo suficiente para a transferência.

> ## QUESTÃO 04
> * A resposta está no código acima.

> ## QUESTÃO 05
> * A resposta está no código acima.
