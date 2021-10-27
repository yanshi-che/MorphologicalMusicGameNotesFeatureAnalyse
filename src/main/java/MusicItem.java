public class MusicItem {
    private final String level;
    private final String difficulty;
    private final String name;
    private final String sentence;
    
    MusicItem(String l,String d,String n,String s){
        level=l;
        difficulty=d;
        name=n;
        sentence=s;
    }

    public final String getLevel(){
        return level;
    }

    public final String getDifficulty(){
        return difficulty;
    }

    public final String getName(){
        return name;
    }

    public final String getSentence(){
        return sentence;
    }
}
