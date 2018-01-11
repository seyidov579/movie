package com.seyidov.movie.controller;

import com.seyidov.movie.model.*;
import com.seyidov.movie.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
public class AddController {
    static String dir = System.getProperty("user.dir");
    private static String UPLOADED_FOLDER = dir + "/src/main/resources/public/media/people/";
    private static String UPLOADED_FOLDERMovie = dir + "/src/main/resources/public/media/movies/";

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private PeopleTypeService peopleTypeService;

    @Autowired
    private PeopleService peopleService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/cabinet/category/add", method = RequestMethod.GET)
    public ModelAndView categoryShow() {
        ModelAndView mav = new ModelAndView();
        Category category = new Category();
        mav.addObject("category", category);
        mav.setViewName("cabinet/category/add");
        return mav;
    }

    @RequestMapping(value = "/cabinet/category/add", method = RequestMethod.POST)
    public ModelAndView categoryAdd(@Valid Category category, BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView();
        if (bindingResult.hasErrors()) {
            mav.setViewName("cabinet/category/add");
        } else {
            categoryService.create(category);
            mav.addObject("successMessage", "Add category successfully");
            mav.addObject("category", new Category());
            mav.setViewName("cabinet/category/add");
        }
        return mav;
    }


    @RequestMapping(value = "/cabinet/country/add", method = RequestMethod.GET)
    public ModelAndView countryShow() {
        ModelAndView mav = new ModelAndView();
        Country category = new Country();
        mav.addObject("country", category);
        mav.setViewName("cabinet/country/add");
        return mav;
    }

    @RequestMapping(value = "/cabinet/country/add", method = RequestMethod.POST)
    public ModelAndView countryAdd(@Valid Country country, BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView();
        if (bindingResult.hasErrors()) {
            mav.setViewName("cabinet/country/add");
        } else {
            countryService.create(country);
            mav.addObject("successMessage", "Add country successfully");
            mav.addObject("country", new Country());
            mav.setViewName("cabinet/country/add");
        }
        return mav;
    }

    @RequestMapping(value = "/cabinet/peopletype/add", method = RequestMethod.GET)
    public ModelAndView peopleTypeShow() {
        ModelAndView mav = new ModelAndView();
        PeopleType category = new PeopleType();
        mav.addObject("peopletype", category);
        mav.setViewName("cabinet/peopletype/add");
        return mav;
    }

    @RequestMapping(value = "/cabinet/peopletype/add", method = RequestMethod.POST)
    public ModelAndView peopleTypeAdd(@Valid PeopleType peopleType, BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView();
        if (bindingResult.hasErrors()) {
            mav.setViewName("cabinet/peopletype/add");
        } else {
            peopleTypeService.create(peopleType);
            mav.addObject("successMessage", "Add People Type successfully");
            mav.addObject("peopletype", new PeopleType());
            mav.setViewName("cabinet/peopletype/add");
        }
        return mav;
    }


    @RequestMapping(value = "/cabinet/people/add", method = RequestMethod.GET)
    public ModelAndView peopleShow() {
        ModelAndView mav = new ModelAndView();
        People category = new People();
        mav.addObject("people", category);
        mav.addObject("peopletype", peopleTypeService.findAll());
        mav.setViewName("cabinet/people/add");
        return mav;
    }

    @RequestMapping(value = "/cabinet/people/add", method = RequestMethod.POST)
    public @ResponseBody
    ModelAndView singleSave(@RequestParam(value = "photo") MultipartFile photo,
                            @RequestParam(value = "first_name") String first_name,
                            @RequestParam(value = "last_name") String last_name,
                            @RequestParam(value = "userid") String[] users) {
        // @Autowired HttpServletRequest request
        People people = new People();
        String fileName = null;
        ModelAndView mav = new ModelAndView();
        if (!photo.isEmpty() && !first_name.isEmpty() && !last_name.isEmpty()) {
            try {
                Random random = new Random();
                byte[] bytes = photo.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + random.nextInt(100) + photo.getOriginalFilename());
                Files.write(path, bytes);
                people.setFirst_name(first_name);
                people.setLast_name(last_name);
                people.setPhoto(path.toString().substring(57));
                // String[] users = request.getParameterValues("userid");
                Set<PeopleType> peopletype = new HashSet<>();
                for (String user : users) {
                    PeopleType peopleType = peopleTypeService.findById(Long.parseLong(user));
                    peopletype.add(peopleType);
                }
                people.setPeopleType(peopletype);
                System.out.println("File upload successful");
            } catch (Exception e) {
                System.out.println("You failed to upload");
                e.printStackTrace();
            }
            peopleService.create(people);
            mav.addObject("successMessage", "Add People successfully");
            mav.addObject("people", new People());
            mav.addObject("peopletype", peopleTypeService.findAll());
            mav.setViewName("cabinet/people/add");
        }
        return mav;
    }

    @RequestMapping(value = "cabinet/movies/add", method = RequestMethod.GET)
    public ModelAndView movieAdd() {
        ModelAndView mav = new ModelAndView();
        Movies movies = new Movies();
        mav.addObject("movies", movies);
        mav.addObject("category", categoryService.findAll());
        mav.addObject("country", countryService.findAll());
        mav.addObject("people", peopleService.findAll());

        mav.setViewName("cabinet/movies/add");
        return mav;
    }

    @RequestMapping(value = "cabinet/movies/add", method = RequestMethod.POST)
    public @ResponseBody ModelAndView movieShow(@RequestParam(value = "name") String name,
                                  @RequestParam(value = "description") String description,
                                  @RequestParam(value = "imdb") Integer imdb,
                                  @RequestParam(value = "cover") MultipartFile cover,
                                  @RequestParam(value = "creatdate") String creatdate,
                                  @RequestParam(value = "minute") String minute,
                                  @RequestParam(value = "countryid") Country countryid,
                                  @RequestParam(value = "categoryid") String[] categoryid,
                                  @RequestParam(value = "writerid") String[] writerid,
                                  @RequestParam(value = "directedid") String[] directedid) throws ParseException {
        ModelAndView mav = new ModelAndView();
        Movies movies = new Movies();
        if (!name.isEmpty() && !description.isEmpty() && !cover.isEmpty()){
            try {
                movies.setName(name);
                movies.setDescription(description);
                movies.setImdb(imdb);
                DateFormat creat = new SimpleDateFormat("dd-MM-yyyy");

                movies.setCreatdate(creat.parse(creatdate));
                DateFormat min = new SimpleDateFormat("HH:mm:ss");
                movies.setMinute(min.parse(minute));
                movies.setCountry(countryid);


                Random random = new Random();
                byte[] bytes = cover.getBytes();
                Path path = Paths.get(UPLOADED_FOLDERMovie + random.nextInt(100) + cover.getOriginalFilename());
                Files.write(path, bytes);
                movies.setCover(path.toString().substring(57));
                System.out.println("File Upload " + cover.getOriginalFilename() + "successful");



                Set<Category> categories = new HashSet<>();
                for (String cat:categoryid){
                    Category category = categoryService.findById(Long.parseLong(cat));
                    categories.add(category);
                }
                movies.setCategory(categories);

                Set<People> peoplies = new HashSet<>();
                for (String writ:writerid){
                    People people = peopleService.findById(Long.parseLong(writ));
                    peoplies.add(people);
                }
                movies.setWriter(peoplies);

                Set<People> peopledir = new HashSet<>();
                for (String direct:directedid){
                    People people = peopleService.findById(Long.parseLong(direct));
                    peopledir.add(people);
                }
                movies.setDirected(peopledir);
                movieService.create(movies);
                mav.addObject("movies", movies);
                mav.setViewName("cabinet/movies/add");
            } catch (IOException e) {
                System.out.println("File Upload " + cover.getOriginalFilename() + "error" + e);
                e.printStackTrace();
            }
        }

        return mav;
    }

    @RequestMapping(value="registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByemail(user.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {

            user.setActive(1);
            Role role = roleService.findByRole("Admin");
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            Set<Role> roles = new HashSet<>();
            roles.add(role);
            user.setRoles(roles);
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("registration");

        }
        return modelAndView;
    }
}