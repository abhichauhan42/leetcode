class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        String str=Integer.toString(k);
        
        ArrayList<Integer> list=new ArrayList<>();
        
        int i=num.length-1;
        int j=str.length()-1;
        
        int carry=0;
        
          while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = i >= 0 ? num[i]: 0;
            int digit2 = j >= 0 ? str.charAt(j) - '0' : 0;
            
            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            list.add(0,sum % 10);
              
            i--;
            j--;
        }
        
        return list;
        
    }
}