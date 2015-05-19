package conv.baze.ui;

public class NumarDubios 
{
    private long Valoare;
    
    static final char Cifra[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    
    static int PozCifra(char c)
      {
        for (int i=0; i<Cifra.length; i++)
            if (c == Cifra[i])
                return i;
        return -1;
      }
    
    NumarDubios()
      { Valoare=0; }
    
    NumarDubios(int numarB10)
      { Valoare=numarB10; }
    
    NumarDubios(String numar, int baza)
      { seteaza(numar, baza); }
    
    void seteaza(String numar, int baza)
      {             
        long put=1;
        int pozCif=numar.length()-1;
        
        Valoare=0;
        
        while (pozCif >= 0)
          {            
            int pc = PozCifra(numar.charAt(pozCif));  
            Valoare = pc * put + Valoare;
            pozCif--;
            put *= baza;
          }         
      }
    
    long inBaza10()
      {
        return Valoare;
      }
    
    String inBaza(int baza)
      {
        long val = Valoare;
        if (val==0) 
            return "0";
        String rez = "";
        while (val != 0)
          {
            int x = (int) (val%baza);
            rez = Cifra[x] + rez;
            val /= baza;
          }
        return rez;
      }
}
