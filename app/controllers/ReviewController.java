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

    private Trie trie;
    private List<ReviewHelper> topReviews;

    /**
     * This is a controller which gets instantiated whenever the application is started
     *
     */
    @Inject
    public ReviewController(){
        trie = new Trie();
    }

    /**
     *A home action which returns the firstpage of the app
     * @return home view where the user is going to feed his input
     */
    public Result index() {
        return ok(views.html.index.render());
    }

    /**
     * This action is used to show allthe reviews which satisfy the input query
     * @return
     */
    public Result showReviews() {
        return ok(views.html.reviews.render(topReviews));
    }


    /**
     * This function reads data from the txt file and stores it in memory into the trie
     * @return redirects to the home page
     * @throws IOException since it reads data from a txt file, where the IOException might occur.
     */
    public Result updateData() throws IOException {
        try {
            NodeHelper.updateData(trie);
            return redirect(routes.ReviewController.index());
        } catch (Exception e) {
            return redirect(routes.ReviewController.caughtError());
        }
    }

    public Result caughtError(){
        return ok(views.html.error.render("Error in parsing the file. Please make sure that " +
                "the input data is in the correct format"));
    }

    /**
     * When the user feeds in his query, this function crawls through the trie and fetches the maximum score reviews
     * @return redirects to the showReviews action to display all the reviews
     */
    public Result getTopReviews() {
        DynamicForm dynamicForm = Form.form().bindFromRequest();
        String tokens[] = dynamicForm.get("tokens").split(" ");
        int k = Integer.parseInt(dynamicForm.get("numberOfResults"));
        topReviews = NodeHelper.getTopReviews(trie, tokens, k);
        return redirect(routes.ReviewController.showReviews());
    }

}
