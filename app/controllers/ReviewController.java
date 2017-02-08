package controllers;

import helpers.NodeHelper;
import helpers.ReviewHelper;
import models.Review;
import models.Trie;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReviewController extends Controller {

    private static final String FILE_PATH = "./data/finefoods.txt";
    private Trie trie;
    private List<ReviewHelper> topReviews;

    @Inject
    public ReviewController() throws IOException {
        trie = new Trie();
    }

    /**
     *
     * @return
     */
    public Result index() {
        return ok(views.html.index.render());
    }

    public Result showReviews() {
        return ok(views.html.reviews.render(topReviews));
    }

    public Result updateData() throws IOException {
        NodeHelper.readFile(FILE_PATH, trie);
        return redirect(routes.ReviewController.index());
    }

    public Result getTopReviews() {
        DynamicForm dynamicForm = Form.form().bindFromRequest();
        String tokens[] = dynamicForm.get("tokens").split(" ");
        int k = Integer.parseInt(dynamicForm.get("numberOfResults"));
        topReviews = NodeHelper.topReviews(trie, tokens, k);
        return redirect(routes.ReviewController.showReviews());
    }

}
