import "./App.css";

import BookDetails from "./BookDetails";
import BlogDetails from "./BlogDetails";
import CourseDetails from "./CourseDetails";

import { books, blogs, courses } from "./data";

function App() {

    const show = true;

    let bookdet = <BookDetails books={books} />;

    let coursedet = <CourseDetails courses={courses} />;

    let content = <BlogDetails blogs={blogs} />;

    return (

        <div className="container">

            <div className="column">

                <h1>Course Details</h1>

                {show && coursedet}

            </div>

            <div className="column">

                <h1>Book Details</h1>

                {bookdet}
            </div>
            <div className="column">
                <h1>Blog Details</h1>
                {content}
            </div>
        </div>
    );

}

export default App;