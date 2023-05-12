+start_auction(ID, EXIT)[source(C)]
    <- .broadcast(tell, auction(ID, EXIT, C)).


@pb1[atomic]
+place_bid(N, _, C)
   :  .findall(b(B, A), place_bid(N, B, C)[source(A)], L) &
      .length(L, 4) &
      .max(L, b(B, W)) &
      B > 0
   <- .print("Winner of exit ", C, " is ", W);
      .send(W, tell, occupied(W));
      .abolish(place_bid(N, _)).
