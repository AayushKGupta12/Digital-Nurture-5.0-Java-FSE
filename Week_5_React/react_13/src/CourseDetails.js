import React from "react";
function CourseDetails(props) {

    return (
        <div>
            {
                props.courses.map((course) => (
                    <div key={course.id}>
                        <h2>{course.cname}</h2>
                        <h5>{course.date}</h5>
                    </div>
                ))
            }
        </div>
    );
}

export default CourseDetails;