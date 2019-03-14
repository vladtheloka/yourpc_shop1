Simple shopping cart appilcation

Functionalities implemented:
-> User registration, authentification and authorization(Sign Up, Login/Logout)

-> Localization(en/ua)

-> User section:
- view all items with photos
- filter items by category
- search items by name
- filter items by price
- sort items by name/price asc/desc
- pagination(change number of items per page)
- add/delete items to/from cart
- view cart 
- flight to cart animation
- make an order from items in cart
- user profile/order details

-> Admin section:
- add/update/delete category
- delete/block/unblock users
- add/update/delete items(including item image)
- delete/update orders

Configuration instruction:
- in src/main/resources/META-INF/persistance.xml change mysql username/password to your:
1) hibernate.connection.username value="****" // **** - your mysql username
2) hibernate.connection.password value="*****" // ***** - your mysql password

- in src/main/java/com.yourpc_shop/serviceimpl/MailSenderServiceImpl change email_from/email_password to your for sending email confirmation after user registration:
1) String EMAIL_FROM = "*******";  ****** - your email
2) String EMAIL_PASSWORD = "*******"; ***** - your email password

- use your_pc.sql file in src/main/webapp/WEB-INF/ to restore database from dump

- move directory "resources" from project root to your apache tomcat installation folder


Technologies used:

- HikariCp(database pooling connection)
- MySql(database) 
- Apache Tomcat(server)
- Maven
- Hibernate JPA(for the management of persistence and object/relational mapping)
- Spring MVC(for model-view-controller presentation)
- Spring Security(for authorization/authentification)
- Apache Tiles(for single page application)
- Apache Commons(for image upload)
- JSP/JSTL(for pages views)
- Javax Mail API(for mail sending)
- JSoup(for HTML parsing)
- Jackson(for serialization java objects to Json objects)
- Json(java API for Json processing)
- Lombok(for reducing boilerplate code for model/data objects)
- Rest API(for HTTP requests to GET, PUT, POST and DELETE data)
- Javascript/Ajax(for scripts/for sending requets from webpage without redirecting)
- HTML/CSS/Bootsrtrap(frontend)

Amount of time spent on the task: around 70-75 hours
