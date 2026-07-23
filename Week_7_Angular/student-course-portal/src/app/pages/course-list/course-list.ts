courses: Course[] = [
  {
    id: 1,
    name: "Angular",
    code: "CS101",
    credits: 4
  },
  {
    id: 2,
    name: "Spring Boot",
    code: "CS102",
    credits: 3
  },
  {
    id: 3,
    name: "React",
    code: "CS103",
    credits: 4
  },
  {
    id: 4,
    name: "Java",
    code: "CS104",
    credits: 3
  },
  {
    id: 5,
    name: "Database",
    code: "CS105",
    credits: 2
  }
];

selectedCourseId?: number;

onEnroll(id: number) {
  console.log("Enrolling in course:", id);
  this.selectedCourseId = id;
}
