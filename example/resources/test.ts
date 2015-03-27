
/**
 * Just a simple class.
 */

module Example {

    export interface Person {
        firstname: string;
        lastname: string;
    }

    class Student implements Person {
        fullname : string;
        constructor(public firstname, public middleinitial, public lastname) {
            this.fullname = firstname + " " + middleinitial + " " + lastname;
        }
    }

    function greeter(person : Person) {
        return "Hello, " + person.firstname + " " + person.lastname;
    }

    var user = new Student("Jane", "M.", "User");
    console.log(greeter(user));

}
