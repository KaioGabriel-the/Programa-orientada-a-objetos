import {question} from 'readline-sync';  // Importa a função para interagir com o usuário via terminal.
import { Postagem } from "./Postagem";   // Importa a classe Postagem, que representa uma postagem em um microblog.

export class Microblog {
    // Lista que armazena as postagens criadas no microblog.
    private postagens: Postagem[];

    /**
     * Construtor da classe `Microblog`.
     * Inicializa a lista de postagens como um array vazio.
     */
    constructor() {
        this.postagens = [];  // Inicializa o array de postagens como vazio.
    }

    /**
     * Método que retorna todas as postagens no microblog.
     * @returns Uma lista com todas as postagens do microblog.
     */
    public getPostagens(): Postagem[] {
        return this.postagens;  // Retorna o array de postagens.
    }

    /**
     * Método que adiciona uma nova postagem ao microblog.
     * Solicita ao usuário o conteúdo da postagem e a adiciona à lista de postagens.
     */
    public addPost(): Postagem {
        // Solicita ao usuário que digite o texto da nova postagem.
        let texto: string = question("Digite o seu post: ");  
        
        // Cria uma nova postagem com o texto fornecido pelo usuário.
        let post: Postagem = new Postagem(texto);  
        
        // Adiciona a postagem criada à lista de postagens.
        this.postagens.push(post);  

        return post;
    }

    /**
     * Método privado que busca o índice de uma postagem a partir do seu ID.
     * @param id O ID da postagem a ser procurada.
     * @returns O índice da postagem ou -1 se não for encontrada.
     */
    private procurarIndexPost(id: number): number {
        let index: number = -1;  // Inicializa o índice como -1, o que indica que a postagem não foi encontrada.

        // Percorre todas as postagens para encontrar a postagem com o ID fornecido.
        for (let i: number = 0; i < this.postagens.length; i++) {
            if (this.postagens[i].id === id) {  // Verifica se o ID da postagem atual corresponde ao ID fornecido.
                index = i;  // Se encontrar, define o índice da postagem.
                break;  // Interrompe o loop, pois já encontramos a postagem com o ID correspondente.
            }
        }

        return index;  // Retorna o índice da postagem ou -1 caso a postagem não tenha sido encontrada.
    }

    /**
     * Método que exclui uma postagem do microblog com base no seu ID.
     * @param id O ID da postagem a ser excluída.
     */
    public excluirPost(id: number): void {
        // Verifica se existe uma postagem com o ID fornecido.
        if (this.postagens.some(post => post.id === id)) {
            // Encontra o índice da postagem usando o ID.
            let index: number = this.procurarIndexPost(id);  
            
            // Remove a postagem do array utilizando o índice encontrado.
            this.postagens.splice(index, 1);  // O método `splice` remove a postagem no índice especificado.
        }
    }

    /**
     * Método que retorna a postagem mais curtida do microblog.
     * @returns A postagem com o maior número de curtidas.
     */
    public maisCurtida(): Postagem {
        let post: Postagem = this.postagens[0];  // Inicializa a primeira postagem como a mais curtida.

        // Percorre todas as postagens e encontra a com maior número de curtidas.
        for (let i of this.postagens) {
            if (post.getCurtida() < i.getCurtida()) {  // Compara as curtidas das postagens.
                post = i;  // Se encontrar uma postagem com mais curtidas, atualiza a referência `post`.
            }
        }

        return post;  // Retorna a postagem com o maior número de curtidas.
    }

    /**
     * Método que permite "curtir" uma postagem, incrementando seu número de curtidas.
     * @param id O ID da postagem a ser curtida.
     */
    public curtir(id: number): void {
        // Encontra o índice da postagem a partir do ID fornecido.
        let indexPost: number = this.procurarIndexPost(id);
        
        // Obtém a postagem no índice encontrado.
        let post: Postagem = this.postagens[indexPost];
        
        // Chama o método `curtir` da classe `Postagem` para incrementar o número de curtidas.
        post.curtir();
    }

    /**
     * Método que imprime todas as postagens do microblog no console.
     * Exibe o texto e o número de curtidas de cada postagem.
     */
    public printPosts(): void {
        // Percorre todas as postagens e imprime a sua representação.
        for (let post of this.postagens) {
            console.log(post.toString());  // Chama o método `toString` da classe `Postagem` para exibir o conteúdo.
        }
    }


}
