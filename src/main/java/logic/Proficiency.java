package logic;

/**
* This is an example enum class which might be updated for particular educational environment to better
* suit it needs. Those are professional qualities which might be associated with particular course,
* and will be required for teacher to have to conduct a lesson within it's course.
* For instance we want to conduct a lesson within calculus course on a subject of integrals for
* international group of students. We need to assign "MATH" and "FOREIGN_LANGUAGE" @proficiencies
* to given course, because those are the skills that are needed to conduct course. This may come
* in handy when assigning teacher to a course and also when we will sek for let's say a replacement.
*
* Please note that those proficiencies are generified for simplifying search for a right teacher,
* more discreet declaration of needed skills are in Skill class. Why? Because being able to teach math
* doesn't specifically imply that teacher is able to teach Linear algebra. It's just a convenient way
* to separate teachers by fields they are operate within.
*/
public enum Proficiency {
    NATIVE_LANGUAGE,        //logic.Teacher is able to teach in native language;
    FOREIGN_LANGUAGE,       //to teach in foreign language;
    MATH,                   //to teach math;
    SOCIAL_STUDIES,         //to teach social studies;
    COACHING                //to be student's group assigned curator;
}
