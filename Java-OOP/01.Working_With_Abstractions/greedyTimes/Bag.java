package greedyTimes;

import java.util.LinkedHashMap;
import java.util.Map;

public class Bag {
    private long capacity;
    private long currentTotalQuantity;
    private long goldAmount;
    private Map<String, Long> gems;
    private long gemsAmount;
    private Map<String, Long> cash;
    private long cashAmount;

    public Bag(long capacity){
        this.capacity = capacity;
        this.currentTotalQuantity = 0;
        this.goldAmount = -1;
        this.gems = new LinkedHashMap<>();
        this.gemsAmount = 0;
        this.cash = new LinkedHashMap<>();
        this.cashAmount = 0;
    }

    public void addCash(String currency, long newCashAmount){
        if (this.gemsAmount >= this.cashAmount + newCashAmount && bagHaveSpace(newCashAmount)){
            this.cashAmount += newCashAmount;
            this.currentTotalQuantity += newCashAmount;

            cash.putIfAbsent(currency, 0L);
            cash.put(currency, cash.get(currency) + newCashAmount);
        }
    }

    public void addGold(long newGoldAmount) {
        if (bagHaveSpace(newGoldAmount)) {
            if (this.goldAmount == -1){
                this.goldAmount = 0;
            }
            this.goldAmount += newGoldAmount;
            this.currentTotalQuantity += newGoldAmount;
        }
    }

    public void addGem(String gemType, long newGemAmount){
        if (this.goldAmount >= this.gemsAmount + newGemAmount && bagHaveSpace(newGemAmount)){
            this.gemsAmount += newGemAmount;
            this.currentTotalQuantity += newGemAmount;

            gems.putIfAbsent(gemType, 0L);
            gems.put(gemType, gems.get(gemType) + newGemAmount);
        }
    }

    public boolean bagHaveSpace(long newAmount){
        return currentTotalQuantity + newAmount <= capacity;
    }

    public void printContent(){
        StringBuilder sb = new StringBuilder();
        if (goldAmount >= 0) {
            sb.append(String.format("<Gold> $%d", this.goldAmount)).append(System.lineSeparator());
            sb.append(String.format("##Gold - %d", this.goldAmount)).append(System.lineSeparator());
        }

        if (!this.gems.isEmpty()){
            sb.append(String.format("<Gem> $%d", this.gemsAmount)).append(System.lineSeparator());
            gems.entrySet().stream().sorted((g1, g2) ->{
                int res = g2.getKey().compareTo(g1.getKey());
                if (res == 0){
                    res = g1.getValue().compareTo(g2.getValue());
                }
                return res;
            }).forEach(e -> sb.append(String.format("##%s - %d", e.getKey(), e.getValue()))
                    .append(System.lineSeparator()));
        }

        if (!this.cash.isEmpty()){
            sb.append(String.format("<Cash> $%d", this.cashAmount)).append(System.lineSeparator());
            cash.entrySet().stream().sorted((g1, g2) ->{
                int res = g2.getKey().compareTo(g1.getKey());
                if (res == 0){
                    res = g1.getValue().compareTo(g2.getValue());
                }
                return res;
            }).forEach(e -> sb.append(String.format("##%s - %d", e.getKey(), e.getValue()))
                    .append(System.lineSeparator()));
        }
        System.out.println(sb.toString().trim());
    }

}
