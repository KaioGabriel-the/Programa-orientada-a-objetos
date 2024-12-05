import {question} from 'readline-sync';
import { Postagem } from "./Postagem";

export class Microblog{
    private postagens : Postagem[];

    constructor(){
        this.postagens = [];
    }

    public getPostagens(): Postagem[]{
        return this.postagens;
    }

    public addPost(): void{
        let texto: string = question(String("Digite o seu post: "));
        let post : Postagem = new Postagem(texto);
        this.postagens.push();
    }

    private procurarIndexPost(id: number): number{
        let index: number = -1;

        for(let i : number = 0; i < this.postagens.length - 1; i++ ){
            if(this.postagens[i].id === id){
                index = i;
                break;
            }
        }

        return index;
    }

    public excluirPost(id : number): void{
        if(this.postagens.some(post=> post.id === id)){
            let index : number = this.procurarIndexPost(id);
            this.postagens.slice(index);
        }
    }
}