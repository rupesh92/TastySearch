package controllers;

import helpers.ReviewHelper;
import models.Review;
import models.Trie;
import play.Logger;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

import play.data.DynamicForm;
import play.data.Form;

import helpers.NodeHelper;

public class ReviewController extends Controller {

    private Trie trie;
    @Inject
    public ReviewController() throws IOException {
        trie = new Trie();
    }

    public Result index() {
        return ok(views.html.index.render());
    }

    public Result updateData() throws IOException {
        NodeHelper.readFile("./data/finefoods.txt", trie);
        return redirect(routes.ReviewController.index());
    }

    public Result getTopReviews(){
        DynamicForm dynamicForm = Form.form().bindFromRequest();
        String tokens[] = dynamicForm.get("tokens").split(" ");
        int k = Integer.parseInt(dynamicForm.get("numberOfResults"));
        List<ReviewHelper> list = NodeHelper.topReviews(trie, tokens, k);
        return ok("Something is loaded");
    }

}
