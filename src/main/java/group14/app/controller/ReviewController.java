/**
 * ReviewController.java
 */
package group14.app.controller;
import group14.app.model.Review;
import group14.app.service.ReviewService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Alex Daniel Popa
 */
@Controller
public class ReviewController {

    @Autowired
    private ReviewService review_service;

	/**
	 *
	 * @param pid
	 * @return index view
	 * @throws Exception
	 */
    @RequestMapping( value = "/review", method = RequestMethod.GET)
    protected String getReview(@RequestParam("pid") String pid) throws Exception {
		review_service.deleteReview(pid);

		return "redirect:index";
    }

	/**
	 *
	 * @return reviews as JSON
	 * @throws Exception
	 */
    @RequestMapping( value = "/reviews", method = RequestMethod.GET)
    protected @ResponseBody List<Review> getReviews() throws Exception {
        List<Review> reviews = review_service.getReviews();
        return reviews;
    }



}
