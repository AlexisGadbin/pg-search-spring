import pandas as pd

file_path = '../src/main/resources/artists.csv'
file_path_sql = '../src/main/resources/data.sql'

artists_df = pd.read_csv(file_path)

insert_statements = []

for index, row in artists_df.iterrows():
    artist_id = row['Artist ID']
    name = row['Name'].replace("'", "''")
    nationality = row['Nationality']
    gender = row['Gender']
    birth_year = 'NULL' if pd.isna(
        row['Birth Year']) else int(row['Birth Year'])
    death_year = 'NULL' if pd.isna(
        row['Death Year']) else int(row['Death Year'])

    insert_statement = f"({artist_id}, '{name}', '{nationality}', '{
        gender}', {birth_year}, {death_year})"
    insert_statements.append(insert_statement)

insert_statements_sql = "INSERT INTO artists (artist_id, name, nationality, gender, birth_year, death_year) VALUES\n" + \
    ",\n".join(insert_statements) + ";"

with open(file_path_sql, 'w', encoding='utf-8') as file:
    file.write(insert_statements_sql)

print(f"Les instructions SQL ont été enregistrées dans {file_path_sql}")
