"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Microblog = void 0;
var readline_sync_1 = require("readline-sync");
var Postagem_1 = require("./Postagem");
var Microblog = /** @class */ (function () {
    function Microblog() {
        this.postagens = [];
    }
    Microblog.prototype.getPostagens = function () {
        return this.postagens;
    };
    Microblog.prototype.addPost = function () {
        var texto = (0, readline_sync_1.question)(String("Digite o seu post: "));
        var post = new Postagem_1.Postagem(texto);
        this.postagens.push();
    };
    Microblog.prototype.procurarIndexPost = function (id) {
        var index = -1;
        for (var i = 0; i < this.postagens.length - 1; i++) {
            if (this.postagens[i].id === id) {
                index = i;
                break;
            }
        }
        return index;
    };
    Microblog.prototype.excluirPost = function (id) {
        if (this.postagens.some(function (post) { return post.id === id; })) {
            var index = this.procurarIndexPost(id);
            this.postagens.slice(index);
        }
    };
    return Microblog;
}());
exports.Microblog = Microblog;
