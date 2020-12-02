def get_int_list():
  int_list = open("input.txt").read().split()
  return list(map(int, int_list)) 