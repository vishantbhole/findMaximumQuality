
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PacketSorter {

    public static void main(String[] args) {
        // Sample input

        List<Integer> packets = List.of(1,2,3,4,5);
        List<Integer> mutablePackets = new ArrayList<>(packets);

        int channels = 2;

        long result = findMaximumQuality(mutablePackets, channels);

        // Output the result
        System.out.println("Result: " + result);
    }


    public static long findMaximumQuality(List<Integer> packets, int channels) {
        Collections.sort(packets) ;
        long resultFinal = 0;
        double m;
        //for 1 channel
        if(channels == 1){
            //return packets.stream() .mapToLong(Integer:: intValue) .sum() ;
            return channels == 1 ? packets.stream() .reduce(0, Integer::sum) : 0;
        }
        //quality for topchannel
        for(int i = 0;i<channels-1;i++){
            resultFinal += packets.get(packets.size() - 1 - i);
        }
        //last channel
        List<Integer> temp = packets.subList(0, packets.size()-(channels - 1)) ;
        //median for remaining packets

        if(temp.size ()% 2 == 0){

            int ml = temp.size()/2;

            int m2 = ml - 1;

            m = (temp.get(ml) + temp.get(m2)) /2.0;

        }else{
            m = temp.get(temp.size() /2) ;
        }

        resultFinal += Math.ceil(m);

        return resultFinal;

    }
}