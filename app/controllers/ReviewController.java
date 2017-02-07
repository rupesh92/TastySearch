package controllers;

import helpers.ReviewHelper;
import models.Review;
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

import services.Node;
import helpers.NodeHelper;

public class ReviewController extends Controller {

    private final FormFactory formFactory;
    private final JPAApi jpaApi;
    private Node node;
    @Inject
    public ReviewController(FormFactory formFactory, JPAApi jpaApi) throws IOException {
        this.formFactory = formFactory;
        this.jpaApi = jpaApi;
        node = new Node();
    }

    public Result index() {
        return ok(views.html.index.render());
    }

    public Result updateData() throws IOException {
        NodeHelper.readFile("./data/finefoods.txt", node);
        return redirect(routes.ReviewController.index());
    }



    public Result getTopReviews(){
        DynamicForm dynamicForm = Form.form().bindFromRequest();
//        Logger.info("Tokens are: " + dynamicForm.get("tokens"));
//        Logger.info("Number of reviews requested are: " + dynamicForm.get("numberOfResults"));
        String tokens[] = dynamicForm.get("tokens").split(" ");
        int k = Integer.parseInt(dynamicForm.get("numberOfResults"));
        List<ReviewHelper> list = NodeHelper.topReviews(node, tokens, k);
//        System.out.print("Size of list is " + list.size());
//        if(list.size() > 0) System.out.println("First doc is" + list.get(0).getReview().product.getProductID() + "with the score of " + list.get(0).getScore());
        return ok("Something is loaded");
    }


//    @Transactional
//    public Result addPerson() {
//        Person person = formFactory.form(Person.class).bindFromRequest().get();
//        jpaApi.em().persist(person);
//        System.out.println(person.name);
//        return redirect(routes.PersonController.index());
//    }

//    @Transactional(readOnly = true)
//    public Result getPersons() {
//        List<Person> persons = (List<Person>) jpaApi.em().createQuery("select p from Person p").getResultList();
//        return ok(toJson(persons));
//    }

}
