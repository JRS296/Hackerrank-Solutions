//unique
for (int i=0; i<len; i++)
{
    if(uq.contains(arr.get(i)))
    {
        //System.out.println("Yes");
        continue;
    }
    else
    {
        uq.add(arr.get(i));
    }
}
//System.out.println(uq);