--liquibase formatted sql
--changeset Andrei Lavrinovich:1.1
DROP VIEW IF EXISTS expenses_overview;
CREATE VIEW expenses_overview AS
SELECT
    expense.id AS "ID",
    expense.name AS "expense_name",
    expense.payment_method AS "payment_method",
    STRING_AGG(DISTINCT tag.name, ', ') AS "tags",
    STRING_AGG(DISTINCT category.name, ', ') AS "categories"
FROM
    expense
        LEFT JOIN
    tag ON expense.id = tag.expense_id
        LEFT JOIN
    category ON expense.id = category.expense_id
GROUP BY
    expense.id, expense.name, expense.payment_method;