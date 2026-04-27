public enum Pigeon{
    FIVE_GUYS_PIGEON("five_guys_pigeon.png", 'A', "You like to " +
    "hang out across the street from the Forbes Ave Five Guys and perch on Vivas Los Tacos. " +  
    "You eat anything off the ground and are generally friendly to the college kids who come feed you."),
    STUDIOUS_PIGEON("studious_pigeon.png", 'B', "You are working hard "
    + "to become a Pigeon Doctor and prove everyone wrong as a minority (species) in your field. " + 
    "You are always looking at students' laptops and books while you fly around Pitt campus."
    ),
    EVIL_PIGEON("evil_pigeon.png", 'C', "You are evil and lurk " + 
    "in the trees so you can poop on people walking under them. You are mischevious and like pranks."
    ),
    PROUD_PIGEON("proud_pigeon.png", 'D', "You always puff out " + 
    "your feathers and try to court the other pigeons and chase them around. It doesn't always " +
    "work out but you try anyways. You love to strut around the street and make yourself appear round " +
    "and fluffy."
    );

    private final String imageName;
    private final char answer;
    private final String description; 

    Pigeon(String imageName, char answer, String description){
        this.imageName = imageName;
        this.answer = answer;
        this.description = description;
    }

    // Getters

    public String getImageName(){
        return imageName;
    }

    public char getAnswer(){
        return answer;
    }

    public String getDescription() {
        return description;
    }
}