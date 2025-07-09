// package com.voting.request;

// import lombok.Data;
// import lombok.NoArgsConstructor;

// @Data
// @NoArgsConstructor
// public class Vote {
//     private Long pollId;
//     private int optionIndex;
// }

package com.voting.request;

public class Vote {
    private Long pollId;
    private int optionIndex;

    public Long getPollId() {
        return pollId;
    }

    public int getOptionIndex() {
        return optionIndex;
    }
}
