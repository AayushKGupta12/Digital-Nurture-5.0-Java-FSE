import React from "react";
function BlogDetails(props) {
    return (
        <div>
            {
                props.blogs.map((blog) => (
                    <div key={blog.id}>
                        <h2>{blog.title}</h2>
                        <h5>{blog.author}</h5>
                        <p>{blog.content}</p>
                    </div>
                ))
            }
        </div>
    );
}

export default BlogDetails;