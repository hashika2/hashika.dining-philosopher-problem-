import java.util.Random;
public class Philosopher {

    //private String forkId;
    private int philosopherId;
    private Fork left,right;

    public Philosopher(int philosopherId){
        this.philosopherId=philosopherId;
    }

    public void start(Fork left,Fork right) throws InterruptedException{

        this.left=left;
        this.right=right;

        while(true){
            if(new Random().nextBoolean()){
                eat();
            }else{
                think();
            }
        }
    }

    public void think() throws InterruptedException{

        System.out.println("The Philosopher: "+philosopherId +" is now thinking");
        Thread.sleep(new Random().nextInt(1000)+100);
        System.out.println("The Philosopher : "+philosopherId +" has stopped thinking.");
    }

    public void eat() throws InterruptedException{

        boolean rightPick=false;
        boolean leftPick=false;

        System.out.println("The philosopher :"+philosopherId +" is now humgry and want to eat.");

        System.out.println("The Philosopher: "+philosopherId+" is now picking up the Fork: "+left.forkId);
        leftPick =left.pick(philosopherId);

        if(!leftPick){
            return;
        }
        System.out.println("the philosopher :"+philosopherId+" is now picking up the fork: "+right.forkId);
        rightPick =left.pick(philosopherId);

        if(!rightPick){
            left.free();
            return;
        }

        System.out.println("The philodopher :"+philosopherId +" is now eating");

        Thread.sleep(new Random().nextInt(1000)+100);

        left.free();
        right.free();

        System.out.println("The philosopher: "+philosopherId+" hasa stopped eating and freed the Forks.");
    }

}
