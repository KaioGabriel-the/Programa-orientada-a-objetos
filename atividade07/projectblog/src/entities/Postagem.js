"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Postagem = void 0;
/**
 * Classe que representa uma postagem em um sistema de rede social ou blog.
 */
var Postagem = /** @class */ (function () {
    /**
     * Construtor da classe `Postagem`.
     * Atribui um ID único à postagem e inicializa o texto da postagem.
     * @param text O texto da postagem.
     */
    function Postagem(text) {
        // ID único da postagem. É inicializado com 0, mas é atribuído na criação da postagem.
        this.id = 0;
        // Quantidade de curtidas que a postagem recebeu, inicializada em 0.
        this.qtdCurtida = 0;
        // Atribui o próximo ID disponível à postagem e incrementa o contador `nextId`.
        this.id = Postagem.nextId;
        Postagem.nextId++;
        // Inicializa o texto da postagem com o valor passado como argumento.
        this.texto = text;
    }
    /**
     * Método que incrementa a quantidade de curtidas da postagem.
     */
    Postagem.prototype.curtir = function () {
        // Aumenta em 1 a quantidade de curtidas da postagem.
        this.qtdCurtida += 1;
    };
    /**
     * Método que retorna a quantidade de curtidas da postagem.
     * @returns A quantidade de curtidas.
     */
    Postagem.prototype.getCurtida = function () {
        // Retorna o número de curtidas da postagem.
        return this.qtdCurtida;
    };
    /**
     * Método que retorna uma representação em string da postagem.
     * @returns A string representando a postagem com o texto e a quantidade de curtidas.
     */
    Postagem.prototype.toString = function () {
        // Monta a string com as informações da postagem.
        var poste = "----- MENSAGEM -----\n".concat(this.texto, " \nCurtir: ").concat(this.getCurtida());
        // Retorna a string formatada.
        return poste;
    };
    // Variável estática que mantém o próximo ID a ser atribuído para cada nova instância da classe.
    Postagem.nextId = 0;
    return Postagem;
}());
exports.Postagem = Postagem;
