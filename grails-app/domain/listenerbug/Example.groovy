package listenerbug

class Example {

	Date created = new Date()
	String prop

    static constraints = {
    	created()
    	prop nullable: true
    }
}
