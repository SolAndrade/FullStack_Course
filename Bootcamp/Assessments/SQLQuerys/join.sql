SELECT accounts.customer_name, branches.branch_name FROM accounts INNER JOIN branches ON accounts.branch_id = branches.id;