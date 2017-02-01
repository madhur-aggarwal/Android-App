package hexa.congressApp.com.congress.model;

import java.util.Comparator;


public class LegislatorsModel implements Comparable<BillsModel>{
    String name,email,chamber,contact,sTerm,eTerm,term,office,
            state,fax,bday,party,partyLogo,imageUrl,facebook,
            twitter,website,secondLine,lastName;

    public LegislatorsModel(String name, String email, String chamber, String contact, String sTerm,
                            String eTerm, String term, String office,
                            String state, String fax, String bday, String party,
                            String partyLogo, String imageUrl,String facebook,
                            String twitter,String website,String secondLine,String lastName) {
        this.name = name;
        this.email = email;
        this.chamber = chamber;
        this.contact = contact;
        this.sTerm = sTerm;
        this.eTerm = eTerm;
        this.term = term;
        this.office = office;
        this.state = state;
        this.fax = fax;
        this.bday = bday;
        this.party = party;
        this.partyLogo = partyLogo;
        this.imageUrl = imageUrl;
        this.facebook=facebook;
        this.twitter=twitter;
        this.website=website;
        this.secondLine=secondLine;
        this.lastName=lastName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getSecondLine() {
        return secondLine;
    }
    public String getWebsite() {
        return website;
    }
    public String getFacebook() {
        return facebook;
    }
    public String getTwitter(){
        return twitter;
    }
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getChamber() {
        return chamber;
    }

    public String getContact() {
        return contact;
    }

    public String getsTerm() {
        return sTerm;
    }

    public String geteTerm() {
        return eTerm;
    }

    public String getTerm() {
        return term;
    }

    public String getOffice() {
        return office;
    }

    public String getState() {
        return state;
    }

    public String getFax() {
        return fax;
    }

    public String getBday() {
        return bday;
    }

    public String getParty() {
        return party;
    }

    public String getPartyLogo() {
        return partyLogo;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public int compareTo(BillsModel billsModel) {
        return 0;
    }
    public static Comparator<LegislatorsModel> FruitNameComparator = new Comparator<LegislatorsModel>() {

        public int compare(LegislatorsModel fruit1, LegislatorsModel fruit2) {

            String fruitName1 = fruit1.getLastName().toUpperCase();
            String fruitName2 = fruit2.getLastName().toUpperCase();

            //ascending order
            return fruitName1.compareTo(fruitName2);

        }

    };
    public static Comparator<LegislatorsModel> StateComperator = new Comparator<LegislatorsModel>() {

        public int compare(LegislatorsModel fruit1, LegislatorsModel fruit2) {

            String fruitName1 = fruit1.getState().toUpperCase();
            String fruitName2 = fruit2.getState().toUpperCase();
            String lName1=fruit1.getLastName().toUpperCase();
            String lName2=fruit2.getLastName().toUpperCase();

           int x= (fruitName1.compareTo(fruitName2));


            if( x==0){
               return lName1.compareTo(lName2);
            }else{

                return  x;
            }

        }

    };
}
