package LA3Q1;

public class IsraValueEntry {
   private Integer key; //this will be our key  for the hash function it is the hashcode

   public IsraValueEntry(){

      key=-1; //null flag for hash table
   }
   public IsraValueEntry(Integer key){

      this.key=key;
   }
   public void setKey(Integer k){// this is to be able to set the keys to the values we are want to add to the hash tables

      key=k;
   }

   public Integer getKey() {//this is to get a key in the hash table to compare it to another key or do operations on it

      return key;
   }
}
