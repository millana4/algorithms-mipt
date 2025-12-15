with open("input.txt") as file_source:
    raw_string = file_source.readline()

raw_list = raw_string.split()

grouped_list = []
added = []

for word in raw_list:
    word_to_check = ''.join(sorted(word.lower()))
    if word_to_check not in added:
        grouped_list.append([word_to_check, word])
        added.append(word_to_check)
    else:
        for word_list in grouped_list:
            if word_list[0] == word_to_check:
                word_list.append(word)

sorted_grouped_list = []

for group in grouped_list:
    clear_group = group[1:]
    sorted_clear_group = sorted(clear_group)
    sorted_grouped_list.append(sorted_clear_group)

alfabeth_sorted_grouped_list = sorted(sorted_grouped_list, key=lambda x: x[0])

with open("output.txt", "w", encoding="utf-8") as file_destination:
    for group in alfabeth_sorted_grouped_list:
        file_destination.write(' '.join(group) + '\n')

