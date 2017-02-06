package controllers;

import play.Logger;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.io.IOException;
import play.data.DynamicForm;
import play.data.Form;

import services.Node;

public class ReviewController extends Controller {

    private final FormFactory formFactory;
    private final JPAApi jpaApi;

    @Inject
    public ReviewController(FormFactory formFactory, JPAApi jpaApi) throws IOException {
        this.formFactory = formFactory;
        this.jpaApi = jpaApi;
        Node root = new Node();
//        NodeHelper.readFile("../../data/finefoods.txt", root);
    }

    public Result index() {
        return ok(views.html.index.render());
    }



    public Result getTopReviews(){
        DynamicForm dynamicForm = Form.form().bindFromRequest();
        Logger.info("Tokens are: " + dynamicForm.get("tokens"));
        Logger.info("Number of reviews requested are: " + dynamicForm.get("numberOfResuls"));
        return ok("ok, I recived POST data. That's all...");
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
