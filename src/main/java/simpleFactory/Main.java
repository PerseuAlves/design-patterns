package simpleFactory;

import simpleFactory.entity.Post;
import simpleFactory.factory.PostFactory;

public class Main {

	public static void main(String[] args) {
		Post postNews = PostFactory.createPost("news");
		Post postBlog = PostFactory.createPost("blog");
		Post postProduct = PostFactory.createPost("product");
		
		System.out.println(postNews);
		System.out.println(postBlog);
		System.out.println(postProduct);
	}
}
