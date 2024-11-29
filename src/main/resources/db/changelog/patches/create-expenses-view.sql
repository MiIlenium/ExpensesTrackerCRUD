

CREATE VIEW expenses_overview AS
SELECT
    expense.id AS "ID",
    expense.name AS "expense name",
    STRING_AGG(DISTINCT tag.name, ', ') AS "tags",
    STRING_AGG(DISTINCT category.name, ', ') AS "categories"
FROM
    expense
        LEFT JOIN
    tag ON expense.id = tag.expense_id
        LEFT JOIN
    category ON expense.id = category.expense_id
GROUP BY
    expense.id, expense.name;