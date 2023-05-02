SELECT customer_name as name, account_type as type, balance FROM accounts 
WHERE account_type = 'checking' AND branch_id = 2;