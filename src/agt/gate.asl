+!start_auction(N)
    <- .broadcast(tell, auction(N)).


@pb1[atomic]
+place_bid(N, _)
   :  .findall(b(B, A), place_bid(N, B)[source(A)], L) &
      .length(L, 4) &
      .max(L, b(B, W)) &
      B > 0
   <- .print("Winner of auction ", N, " is ", W, " with ", B);
      .send(W, tell, occupied(W));
      .abolish(place_bid(N, _)).
