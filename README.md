<h1>REST Controller for the database</h1>
<a href="https://problem-book-database.herokuapp.com/">Link</a>

<h2>Methods allowed</h2>

<h3>Student controller</h3>
<ul>
<li>[GET] /student/name="" : returns a StudentEntity for the specified name or null if the name does not exist.</li>
<li>[POST] /student/register [BODY] RegisterDTO : given a RegisterDTO object (with the Special Field containing the Registration Number), it registers the student and returns a ReturnCode constant.</li>
<li>[POST] /student/login [BODY] LoginDTO : given a LoginDTO object (with the Special Field containing the Registration Number), it tries to log in the student.</li>
<li>[PUT] /student?studentId=""&avatarId="" : changes the avatar preference for a given student</li>
</ul>

<h3>Teacher controller</h3>
<ul>
<li>[GET] /teacher/name="" : returns a TeacherEntity for the specified name or null if the name does not exist.</li>
<li>[POST] /teacher/register [BODY] RegisterDTO : given a RegisterDTO object (with the Special Field containing the email), it registers the teacher and returns a ReturnCode constant.</li>
<li>[POST] /teacher/login [BODY] LoginDTO : given a LoginDTO object (with the Special Field containing the email), it tries to log in the teacher.</li>
<li>[PUT] /teacher?teacherId=""&avatarId="" : changes the avatar preference for a given teacher</li>
</ul>

<h3>Problem controller</h3>
<ul>
<li>[GET] /problem/findById?id="" : given an ID, it returns a ProblemDTO associated with it, or null if the ID does not exist.</li>
<li>[GET] /problem/findNext?id="" : given an ID, it returns a ProblemDTO associated with the next ID.</li>
<li>[GET] /problem/findPrevious?id="" : given an ID, it returns a ProblemDTO associated with the previous ID.</li>
<li>[POST] /problem/ [BODY] ProblemDTO : given a ProblemDTO, it adds the problem into the database.</li>
</ul>

<h3>Avatar controller</h3>
<ul>
<li>[GET] /avatar/id="" : given an ID, it returns an AvatarDTO associated with it or null if it does not exist.</li>
<li>[POST] /avatar/url="" : given a valid URL, it adds it into the database.</li>
</ul>