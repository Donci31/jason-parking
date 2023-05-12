+wants_to_park(EXIT)[source(CAR)]
    <- .print(CAR, " wants to park, wants to exit at ", EXIT, ". Broadcasting auction.");
      .broadcast(tell, auction(EXIT, CAR)).

@pb1[atomic]
+place_bid(D, CAR)
   :  number_of_park_places(N) &
      .findall(bid(BID_VALUE, BID_FROM), place_bid(BID_VALUE, CAR)[source(BID_FROM)], ALL_BIDS) &
      .length(ALL_BIDS, N) & 
      .findall(bid(BID_VALUE, BID_FROM), place_bid(BID_VALUE, CAR)[source(BID_FROM)] & BID_VALUE > 0, VALID_BIDS) &
      .min(VALID_BIDS, bid(WINNER_BID_VALUE, WINNER_BID_FROM))
   <- .print("All bids received for ", CAR, ": ", ALL_BIDS);
      .print("Valid bids received for ", CAR, ": ", VALID_BIDS);
      .print("Winner bid for ", CAR, ": ", WINNER_BID_VALUE, " from ", WINNER_BID_FROM);
      .send(WINNER_BID_FROM, tell, occupied);
      .send(CAR, tell, parked).

number_of_park_places(0).

+spawn_parking_place: number_of_park_places(N)
   <- .print("Number of park places: ", N + 1);
      .abolish(number_of_park_places(_));
      +number_of_park_places(N + 1).
