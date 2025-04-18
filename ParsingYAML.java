import java.util.ArrayList;
import java.util.StringTokenizer;

class ParsingYaml {
    String s;
    ArrayList<String> parsingArray = new ArrayList<String>();


    public ParsingYaml(String s) {
        this.s = s;


    }
    public void ParsingProject() {
        
        int stringLength = s.length();
        StringTokenizer st = new StringTokenizer(s, ": ");

        // Tokenize the string and print each token
        while (st.hasMoreTokens()) {
            this.parsingArray.add(st.nextToken());
            this.parsingArray.add(st.nextToken());
        }print();
    }
    public void print(){
        for(int x = 0; x<this.parsingArray.size(); x++){
            System.out.println("key:"+ " " + this.parsingArray.get(x));
            x++;
            System.out.println("value:" + " " + this.parsingArray.get(x));

        }
    }
    public boolean search(String goal){
        for(int x = 0; x<this.parsingArray.size(); x++){
            if(this.parsingArray.get(x).equals(goal) ){
                return true;
            }
        }return false;
    }
}

class Tokenizer {
    String s;
    int len;
    int pos;
    ArrayList<String> token;

    public Tokenizer(String s) {
        this.s = s;
        this.len = s.length();
        this.pos = 0;
        this.token = new ArrayList<String>();
    }
    public void codeRunner(){
        checkId();
        while(this.pos < this.len){

            if(Character.isLetterOrDigit(this.s.charAt(this.pos))){
                checkId();
            }else if(Character.isWhitespace(this.s.charAt(this.pos))){
                addwhiteSpace();
            }
        }print(); 
    }

    public void checkId() {
        for (int x = this.pos; x < this.len; x++) {
            if (this.s.charAt(x) == ':') {
                this.token.add("id");
                this.token.add("colon");
                this.pos = x + 1;
                return;
            } else if (this.s.charAt(x) == ' ') { 
                addNumOrString();
                this.pos = x; 
                return;
            }
        }
        addNumOrString();
        this.pos = this.len;
    }
    

    public void addwhiteSpace() {
        this.token.add("white space");
        this.pos++;
    }

    public void addNumOrString() {
        if(Character.isDigit((this.s.charAt(this.pos)))){
            token.add("number");
        }else{
            token.add("string");

        }
    }

    public void print(){
        System.out.println(this.token);
    }

}

class Main {
    public static void main(String[] args) {
        String yaml_content = "name1: khalid name2: 33";
        Tokenizer obj = new Tokenizer(yaml_content);

        obj.codeRunner();
        

        ParsingYaml q = new ParsingYaml(yaml_content);
        q.ParsingProject();
       System.out.println(q.search("khalid"));
      
      
    }
}

// TIMR IS N
// SPACE IS 1