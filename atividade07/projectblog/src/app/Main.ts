import { Microblog } from "../entities/Microblog";

function main():void {
    let blog : Microblog = new Microblog();
    let post01 = blog.addPost();
    let post02 = blog.addPost();
    blog.printPosts();
    blog.curtir(post01.id);
    blog.excluirPost(post02.id);
    blog.printPosts();

}

main();