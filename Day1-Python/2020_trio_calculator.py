import txt_processor

def does_add_to_2020(int1, int2, int3):
  return (int1 + int2 + int3) == 2020

def find_2020_ints(first_int, position, int_list):
  length = len(int_list)

  if (length < 2):
    return

  if position >= length:
    int_list.pop(0)
    first_int = int_list[0]
    return find_2020_ints(first_int, 1, int_list)

  second_int = int_list[position]
  i = position + 1
  while i < length:
    if does_add_to_2020(first_int, second_int, int_list[i]):
      print("% s and % s and % s add up to 2020!"% (first_int, second_int, int_list[i]))
      print("The product of all three is % s"% (first_int * second_int * int_list[i]))
      return
    else:
      i += 1

  position += 1
  return find_2020_ints(first_int, position, int_list)

def main():
  input_list = txt_processor.get_int_list()
  input_list.sort()
  find_2020_ints(input_list[0], 1, input_list)

if __name__ == "__main__":
  main()
